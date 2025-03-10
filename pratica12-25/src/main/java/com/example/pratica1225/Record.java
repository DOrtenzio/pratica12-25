package com.example.pratica1225;

public class Record {
    private String comune,provincia,nomeItaliano,nomeTedesco,proprieta,telefono,email, internet,gruppo;
    private int altitudineInM;

    public Record(String comune, String provincia, String nomeItaliano, String nomeTedesco, String proprieta, String telefono, String email, String internet, String gruppo, int altitudineInM) {
        this.comune = comune;
        this.provincia = provincia;
        this.nomeItaliano = nomeItaliano;
        this.nomeTedesco = nomeTedesco;
        this.proprieta = proprieta;
        this.telefono = telefono;
        this.email = email;
        this.internet = internet;
        this.gruppo = gruppo;
        this.altitudineInM = altitudineInM;
    }

    public String getComune() { return comune; }
    public void setComune(String comune) { this.comune = comune; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getNomeItaliano() { return nomeItaliano; }
    public void setNomeItaliano(String nomeItaliano) { this.nomeItaliano = nomeItaliano; }
    public String getNomeTedesco() { return nomeTedesco; }
    public void setNomeTedesco(String nomeTedesco) { this.nomeTedesco = nomeTedesco; }
    public String getProprieta() { return proprieta; }
    public void setProprieta(String proprieta) { this.proprieta = proprieta; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getInternet() { return internet; }
    public void setInternet(String internet) { this.internet = internet; }
    public String getGruppo() { return gruppo; }
    public void setGruppo(String gruppo) { this.gruppo = gruppo; }
    public int getAltitudineInM() { return altitudineInM; }
    public void setAltitudineInM(int altitudineInM) { this.altitudineInM = altitudineInM; }

    @Override
    public String toString() {
        return comune+";"+proprieta+";"+nomeItaliano+";"+nomeTedesco+";"+altitudineInM+";"+proprieta+";"+telefono+";"+email+";"+internet+";"+gruppo;
    }
}
