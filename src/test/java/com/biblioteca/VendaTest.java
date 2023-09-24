package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VendaTest {

    @Test
    public void testConstrutorComParametros() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 1);

        List<LivroVenda> listLivroVenda = new ArrayList<LivroVenda>();
        listLivroVenda.add(livroVenda);

        Venda venda = new Venda("Nome Cliente", "Dinheiro", 500.00, listLivroVenda);

        Assert.assertEquals(500, venda.valorDado, 0.01);
        Assert.assertEquals("Dinheiro", venda.formaPagamento);
        Assert.assertEquals("Nome Cliente", venda.nomeCliente);
        Assert.assertEquals(listLivroVenda, venda.livros);
    }

    @Test
    public void testConstrutorPadrao() {
        Venda venda = new Venda();
        Assert.assertNull(venda.nomeCliente);
        Assert.assertNull(venda.formaPagamento);
        Assert.assertNull(venda.livros);
        Assert.assertEquals(0, venda.valorDado, 0.01);
    }
}
