public class PrincipalProduto {
    public static void main(String[]args){
        Produto p1 = new Produto("001", "Caneta", 2.50, 100, 10);
        Produto p2 = new Produto("002", "Caderno", 15.00, 50, 5);
        
        System.out.println("Produto 1: " + p1.getNome() + ", Código: " + p1.getCodigo() + ", Preço: R$" + p1.getPreco() + ", Quantidade: " + p1.getQuantidade());
        System.out.println("Produto 2: " + p2.getNome() + ", Código: " + p2.getCodigo() + ", Preço: R$" + p2.getPreco() + ", Quantidade: " + p2.getQuantidade());
        
        p1.vender(20);
        System.out.println(p1.getQuantidade());
        p1.repor(15);
        System.out.println(p1.getQuantidade());
        p1.aplicarDesconto(10);
        System.out.println(p1.getPreco());
        p2.vender(60);
        System.out.println(p2.getQuantidade());
        p2.repor(30);
        System.out.println(p2.getQuantidade());
        p2.vender(79);
        p2.aplicarDesconto(30);
        System.out.println(p2.getPreco());

        p1.exibirDados();
        p2.exibirDados();
        


    }
}
