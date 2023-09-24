package com.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class LivroVendaTest {

    @Test
    public void testConstrutorComParametros() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 0;
        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        Assert.assertEquals(quantidade, livroVenda.quantidade);
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
    }

    @Test
    public void testConstrutorPadrao() {
        LivroVenda vendaPadrao = new LivroVenda();
        Assert.assertNull(vendaPadrao.livroDoEstoque);
        Assert.assertEquals(0, vendaPadrao.quantidade);
    }

    @Test
    public void testIncrementarQuantidade() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 0;
        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        livroVenda.IncrementarQuantidade();

        Assert.assertEquals(quantidade + 1, livroVenda.quantidade);
    }

    @Test
      public void testIncrementarQuantidadeComValor() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 0;        
        int quantidadeAumentar = 5;

        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        livroVenda.IncrementarQuantidade(quantidadeAumentar);

        Assert.assertEquals(quantidade + quantidadeAumentar, livroVenda.quantidade);
    }

     @Test
      public void testDecrementarQuantidade() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 5;        
        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        Assert.assertTrue(livroVenda.DecrementarQuantidade());
        Assert.assertEquals(quantidade - 1, livroVenda.quantidade);
    }

      @Test
      public void testDecrementarQuantidadeComValor() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 5;        
        int quantidadeDiminuir = 3;

        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        Assert.assertTrue(livroVenda.DecrementarQuantidade(quantidadeDiminuir));
        Assert.assertEquals(quantidade - quantidadeDiminuir, livroVenda.quantidade);
    }

     @Test
      public void testDecrementarQuantidadeMenorQueZero() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 0;        

        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        Assert.assertFalse(livroVenda.DecrementarQuantidade());
        Assert.assertEquals(quantidade, livroVenda.quantidade);
    }

     @Test
      public void testDecrementarQuantidadeMenorQueZeroComValor() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);
        int quantidade = 2;        
        int quantidadeDiminuir = 3;

        
        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        Assert.assertFalse(livroVenda.DecrementarQuantidade(quantidadeDiminuir));
        Assert.assertEquals(quantidade, livroVenda.quantidade);
    }
}
