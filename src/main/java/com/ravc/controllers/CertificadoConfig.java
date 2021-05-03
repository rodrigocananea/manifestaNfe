/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.controllers;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ;
import com.ravc.utils.Notify;
import com.ravc.utils.StatusProgress;
import com.ravc.utils.TipoCertificadoA3;
import com.ravc.utils.Tools;
import static com.ravc.views.Main.jcbTipoCertificadoA3;
import static com.ravc.views.Main.jcbUFEmitente;
import static com.ravc.views.Main.jrbA1;
import static com.ravc.views.Main.jrbA3;
import static com.ravc.views.Main.jtfCNPJCPF;
import static com.ravc.views.Main.jtfSenha;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class CertificadoConfig {

    public static ConfiguracoesNfe iniciaConfiguracoes() throws NfeException, IOException {

        Certificado certificado = null;
        ConfiguracoesNfe ConfiguracoesNfe = null;
        String cnpjcpf = jtfCNPJCPF.getText().replaceAll("\\D", "");
        try {
            certificado = getCertDig(cnpjcpf);
            ConfiguracoesNfe = ConfiguracoesNfe.criarConfiguracoes(EstadosEnum.valueOf(jcbUFEmitente.getSelectedItem().toString()),
                    AmbienteEnum.PRODUCAO, certificado, Tools.getProgramFiles() + File.separator + "schemas");
        } catch (Exception ex) {
            String message = ex.getMessage();
            if (message == null) {
                message = "\nNão conseguimos obter o certificado digital para\n"
                        + "assinar o documento, por favor verifique se ele\n"
                        + "está funcionando corretamente no seu computador.";
            }
            JOptionPane.showMessageDialog(null, "Problemas ao consultar certificado, motivo:\n" + message, "Consulta certificado digital", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return ConfiguracoesNfe;
    }

    public static Certificado getCertDig(String cnpjcpf) throws Exception {
        Certificado cert = null;
        String senha = jtfSenha.getText();
        if (senha == null) {
            senha = "";
        }
        if (jrbA1.isSelected()) {
            cert = CertificadoService.getCertificadoByCnpjCpf(cnpjcpf);
        } else if (jrbA3.isSelected()) {
            TipoCertificadoA3 type = TipoCertificadoA3.valueOf(jcbTipoCertificadoA3.getSelectedItem().toString());
            cert = CertificadoService.certificadoA3(type.getMarca(), type.getDll(), senha);
        }
        return cert;
    }

    public static void getStatus(StatusProgress progress) {
        try {
            ConfiguracoesNfe config = iniciaConfiguracoes();

            String xMsg = "";
            TRetConsStatServ retorno = Nfe.statusServico(config, DocumentoEnum.NFE);

            if (retorno.getCStat().equals("107")) {
                if (retorno.getTpAmb().equals("1")) {
                    xMsg = "Ambiente de Produção\n";
                } else {
                    xMsg = "Ambiente de Homologação\n";
                }
                xMsg = xMsg + retorno.getXMotivo() + "\nCódigo IBGE da UF: " + retorno.getCUF() + "\nData/Hora: " + retorno.getDhRecbto() + "\nTempo Médio de Resposta(segundos): " + retorno.getTMed();
            } else {
                xMsg = "Serviço inativo/inoperante";
            }
            progress.dispose();
            Notify.open(true).setIcon(Notify.ICON_HAPPY)
                    .setMessage("Sucesso!\nConsulta realizada, abaixo segue informações de retorno:")
                    .setDescription(xMsg)
                    .get();
        } catch (Exception e) {
            progress.dispose();
            Notify.open(true).setIcon(Notify.ICON_ERROR)
                    .setMessage("Oops!\nOcorreu algum problema na consulta, motivo:")
                    .setDescription(e.getMessage())
                    .get();
        }

    }
}
