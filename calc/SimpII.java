package calc;

public class SimpII extends Intervalo {
	
	public SimpII(double inicio, double fim, int n) {
		super(inicio, fim, n);
		
		if(inicio > fim) {
			double aux = inicio;
			inicio = fim;
			fim = aux;
		}
		
		if(n % 3 == 0) {
			subs = new Ponto[n + 1];
			h = (fim - inicio) / n;
			preecherPts();
		} else {
			System.err.println("Erro em SimpII");
			System.err.println("O intervalo deve ser um múltiplo de 3!");
			System.exit(0);
		}
	}
	
	// 3/8
	public double getIntegral() {
		double in;

		in = subs[0].getFx() + subs[subs.length - 1].getFx();
		for(int i = 1; i < subs.length - 1; i++) {
			if(i % 3 == 0) {
				in += 2 * subs[i].getFx();
			} else {
				in += 3 * subs[i].getFx();
			}
		}
		// 0.375 = 3/8
		return 0.375 * h * in;
	}
	
	public double getErro() {
		double intAt = getIntegral();
		double intExa = new SimpII(inicio, fim, 99).getIntegral();
		
		return Math.abs(intExa - intAt);
	}
}
