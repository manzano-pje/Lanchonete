package com.teste.Lanchonete.exceptions;

import java.util.HashMap;
import java.util.Map;
import lombok.Generated;

public class ErrorResponse extends RuntimeException {
    private String mensagem;
    private Integer codigo;

    public ErrorResponse(String mensagem, Integer codigo) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public Map<String, Object> paraJson() {
        Map<String, Object> json = new HashMap();
        json.put("Código:", this.codigo);
        json.put("Erro: ", this.mensagem);
        return json;
    }

    @Generated
    public String getMensagem() {
        return this.mensagem;
    }

    @Generated
    public Integer getCodigo() {
        return this.codigo;
    }

    @Generated
    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    @Generated
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponse)) {
            return false;
        } else {
            ErrorResponse other = (ErrorResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$codigo = this.getCodigo();
                Object other$codigo = other.getCodigo();
                if (this$codigo == null) {
                    if (other$codigo != null) {
                        return false;
                    }
                } else if (!this$codigo.equals(other$codigo)) {
                    return false;
                }

                Object this$mensagem = this.getMensagem();
                Object other$mensagem = other.getMensagem();
                if (this$mensagem == null) {
                    if (other$mensagem != null) {
                        return false;
                    }
                } else if (!this$mensagem.equals(other$mensagem)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $codigo = this.getCodigo();
        result = result * 59 + ($codigo == null ? 43 : $codigo.hashCode());
        Object $mensagem = this.getMensagem();
        result = result * 59 + ($mensagem == null ? 43 : $mensagem.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getMensagem();
        return "ErrorResponse(mensagem=" + var10000 + ", codigo=" + this.getCodigo() + ")";
    }
}
