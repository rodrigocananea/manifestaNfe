/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.controllers;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.Evento;
import br.com.swconsultoria.nfe.schema.envConfRecebto.TEnvEvento;
import br.com.swconsultoria.nfe.schema.envConfRecebto.TRetEnvEvento;
import br.com.swconsultoria.nfe.schema.envConfRecebto.TretEvento;
import br.com.swconsultoria.nfe.util.ManifestacaoUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import com.ravc.utils.Notify;
import com.ravc.utils.StatusProgress;
import com.ravc.utils.Tools;

/**
 *
 * @author Rodrigo
 */
public class ManifestarNfe {

    public void manifesta(Evento manifesta, StatusProgress progress) {
        try {
            progress.jlStatusText.setText("Inicializando certificado digital, aguarde...");
            ConfiguracoesNfe config = CertificadoConfig.iniciaConfiguracoes();

            TEnvEvento enviEvento = ManifestacaoUtil.montaManifestacao(manifesta, config);

            progress.jlStatusText.setText("Enviando manifestação, aguarde...");
            TRetEnvEvento retorno = Nfe.manifestacao(config, enviEvento, true);

            progress.jlStatusText.setText("Validando retorno da manifestação, aguarde...");
            RetornoUtil.validaManifestacao(retorno);

            String protocolo = "";
            progress.dispose();
            for (TretEvento resultado : retorno.getRetEvento()) {
                Notify.open(true).setMessage("Sucesso!\nManifestação enviada com sucesso, informações abaixo:")
                        .setDescription("Chave: " + resultado.getInfEvento().getChNFe()
                                + "\nStatus: " + resultado.getInfEvento().getCStat() + " - " + resultado.getInfEvento().getXMotivo()
                                + "\nProtocolo: " + resultado.getInfEvento().getNProt())
                        .get();
                protocolo = resultado.getInfEvento().getNProt();
            }

            //Cria ProcEvento de Manifestacao
            String proc = ManifestacaoUtil.criaProcEventoManifestacao(config, enviEvento, retorno.getRetEvento().get(0));
            Tools.protocolo(proc, protocolo);
        } catch (Exception e) {
            progress.dispose();
            System.err.println();
            System.err.println("# Erro: " + e.getMessage());
        }
    }
}
