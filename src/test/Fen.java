package test;

public class Fen {
    private  int  fenZi;
    private  int  fenMu;

    public Fen() {
    }

    public Fen(int fenZi, int fenMu) {
        this.fenZi = fenZi;
        this.fenMu = fenMu;
    }

    @Override
    public String toString() {
        if (fenMu == 1){
            return fenZi+"";
        }
        return fenZi +"/" + fenMu;
    }

    public int getFenZi() {
        return fenZi;
    }

    public void setFenZi(int fenZi) {
        this.fenZi = fenZi;
    }

    public int getFenMu() {
        return fenMu;
    }

    public void setFenMu(int fenMu) {
        this.fenMu = fenMu;
    }
}
