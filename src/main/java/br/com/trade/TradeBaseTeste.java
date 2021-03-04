package br.com.trade;

public class TradeBaseTeste extends BaseTeste {

    public String getBaseUrl() {
        return "https://testeqa.tradetechnology.com.br/login";
    }

    @Override
    public String getUsuario() {
        return "test";
    }

    @Override
    public String getSenha() {
        return "password";
    }

    public String getBaseUrlAdmin() { return "https:/testeqa.tradetechnology.com.br/admin/login";}
}

