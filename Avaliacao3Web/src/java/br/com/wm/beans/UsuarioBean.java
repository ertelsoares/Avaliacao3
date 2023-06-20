package br.com.wm.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    String usuario, senha , nomedoUsuario;
    
    boolean logado = false, admin = false;
    public UsuarioBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomedoUsuario() {
        return nomedoUsuario;
    }

    public boolean isLogado() {
        return logado;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    public String login(){
        if("admin".equals(usuario) && "admin123".equals(senha)){
            logado = true;
            admin = true;
            nomedoUsuario = "Administrador";
            
            return "admin/index.xhtml";
        }
        return null;
    }
    
    public String logout(){
        logado = false;
        admin = false;
        nomedoUsuario = null;
        usuario = null;
        senha = null;
        return null;
    }
}
