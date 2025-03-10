package com.example.pratica1225;

public class RecordAggiunte extends Record{
    private boolean isVisibile;
    private int miovalore;

    public RecordAggiunte(String comune, String provincia, String nomeItaliano, String nomeTedesco, String proprieta, String telefono, String email, String internet, String gruppo, int altitudineInM, int miovalore, boolean isVisibile) {
        super(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudineInM);
        this.isVisibile=isVisibile;
        this.miovalore=miovalore;
    }

    public boolean isVisibile() {
        return isVisibile;
    }

    public void setVisibile(boolean visibile) {
        isVisibile = visibile;
    }

    public int getMiovalore() {
        return miovalore;
    }

    public void setMiovalore(int miovalore) {
        this.miovalore = miovalore;
    }

    @Override
    public String toString() {
        return super.toString()+";"+miovalore+";"+isVisibile;
    }
}
