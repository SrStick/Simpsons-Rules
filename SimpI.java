package calc;

public class SimpI extends Intervalo {
	
	public SimpI(double inicio, double fim, int n) {
		super(inicio, fim, n);
		
		if(inicio > fim) {
			double aux = inicio;
			inicio = fim;
			fim = aux;
		}
		
		if(n % 2 == 0) {
			subs = new Ponto[n + 1];
			h = (fim - inicio) / n;
			preecherPts();
		} else {
			System.out.println("Erro em SimpI");
			System.out.println("O intervalo deve ser par!");
			System.exit(0);
		}
	}
	
	// 1/3
	public double getIntegral() {
		  double in;
		  
		  in = subs[0].getFx() + subs[subs.length - 1].getFx();
		  for(int i = 1; i < subs.length - 1; i++) {
			  if(i % 2 == 0) {
				  in += 2 * subs[i].getFx();
			  } else {
				  in += 4 * subs[i].getFx();
			  }
		  }
		  return (h / 3) * in;
	}
	
	public double getErro() {
		double intAt = getIntegral();
		double intExa = new SimpI(inicio, fim, 80).getIntegral();
		
		return Math.abs(intExa - intAt);
	}
}
