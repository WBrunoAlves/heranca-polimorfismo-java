package entities;



public class PFisica extends Pagador{
	
	private Double valorGastoSaude;


	public PFisica(String nome, Double rendaAnual, Double valorGastoSaude) {
		super(nome, rendaAnual);
		this.valorGastoSaude = valorGastoSaude;
	}

	
	public Double getValorGastoSaude() {
		return valorGastoSaude;
	}

	public void setValorGastoSaude(Double valorGastoSaude) {
		this.valorGastoSaude = valorGastoSaude;
	}

	/*
	 * Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
		renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
		destes gastos são abatidos no imposto.
		Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
		fica: (50000 * 25%) - (2000 * 50%) = 11500.00
			 * */
	
	
	@Override
	public double tax() {
		
		if (getRendaAnual() < 20000.00) {
			
			return getRendaAnual() * 0.15 - valorGastoSaude * 0.50;
			
			
		} else {
			return getRendaAnual() * 0.25 - valorGastoSaude * 0.50;
		}

	}
	
}
