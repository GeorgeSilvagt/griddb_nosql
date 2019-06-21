public class Conta {
	int numero;
	Cliente titular = new Cliente(null);
	private double saldo;
	double limite;
	private static int totalDeContas;
	
	Conta(){
		Conta.totalDeContas += 1;
	}
	
	public static int getTotalDeContas() {
		return Conta.totalDeContas;
	}
	
	Conta(Cliente titular){
		this.titular = titular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	void sacar(double quantidade) {
		if(quantidade > this.saldo) {
			System.out.println("Não saldo suficiente: ");
		}else {
		double novoSaldo = this.saldo - quantidade;
		this.saldo = novoSaldo;
		}
	}
	
	boolean saca(double valor) {
		if(this.saldo < valor ) {
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
				return true;
		}
	}
	
	
	void depositar(double quantidade) {
		this.saldo = this.saldo + quantidade;
	}
	
	
	//outra forma menos segura de "transfere"
	/*void transfere(Conta destino, double valor) {
		this.saldo -= valor;
		destino.saldo += valor;
		
	}*/
	
	boolean transferePara(Conta destino, double valor) {
		boolean retirou = saca(valor);
		
		if(retirou==false) {
			System.out.println("Não ha saldo suficiente!");
			return false;
		}
		
		else {
		destino.depositar(valor);
		return true;
		}
	}
	

}
