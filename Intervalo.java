package calc;

abstract class Intervalo {
  protected Ponto[] subs;
  protected final double inicio, fim;
  protected double h;
  protected int n;

  protected Intervalo(double inicio, double fim, int n) {
    if (inicio > fim) {
      double aux = inicio;
      inicio = fim;
      fim = aux;
    }
    
    this.inicio = inicio;
    this.fim = fim;
    this.n = n;
  }
  
  protected static double getF(double x) {
	  return Math.exp(x);
  }

  protected void preecherPts() {
    double aux = inicio;
    for (int i = 0; i < subs.length; i++) {
      subs[i] = new Ponto(aux, getF(aux));
      aux += h;
    }
  }

  public Object[][] getPontos() {
    Object[][] mat = new Object[subs.length][2];
    
    for(int i = 0; i < subs.length; i++) {
    	mat[i][0] = subs[i].getX();
    	mat[i][1] = subs[i].getFx();
    }
    
    return mat;
  }

  public int getN() {
	  return n;
  }
}
