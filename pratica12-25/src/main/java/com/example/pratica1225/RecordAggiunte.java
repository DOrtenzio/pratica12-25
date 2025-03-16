package com.example.pratica1225;

import java.util.Random;

public class RecordAggiunte extends Record{
    private boolean isVisibile;
    private int miovalore;

    public RecordAggiunte(String comune, String provincia, String nomeItaliano, String nomeTedesco, String proprieta, String telefono, String email, String internet, String gruppo, int altitudineInM) {
        super(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudineInM);
        this.isVisibile=true;
        this.miovalore=new Random().nextInt(11) + 10;
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
