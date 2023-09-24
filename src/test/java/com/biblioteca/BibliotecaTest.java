package com.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BibliotecaTest {

    //Talvez seria melhor ajustar classe Biblioteca para retornar boolean, 
    //e verificar se já existe o livro antes de adicionar ou remover na lista, em todos métodos da classe.
    @Test
    public void testAdicionarLivro() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.AdicionarLivro(livro);
            
        Assert.assertTrue(biblioteca.livros.contains(livro));
    }

    @Test
    public void testAdicionarLivroRepetido() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarLivro(livro);

        try {
            biblioteca.AdicionarLivro(livro);

            Assert.fail("Foi permitido adicionar um livro que foi adicionado anteriormente");
            } catch (Exception ex) {
            Assert.fail(("Erro ao adicionar livro repetido: " + ex.getMessage()));
            }
    }

    @Test
    public void testRemoverLivro() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);

        Assert.assertFalse(biblioteca.livros.contains(livro));
    }
    
    @Test
    public void testRemoverLivroNaoExistente() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);

        try {
            biblioteca.RemoverLivro(livro);
            Assert.fail(("Permitiu remover livro não existente sem exibir erro"));
            } catch (Exception ex) {
            Assert.fail(("Erro ao remover livro não existente: " + ex.getMessage()));
            }
    }

    @Test
    public void testAdicionarAutor() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.AdicionarAutor(autor);
        Assert.assertTrue(biblioteca.autores.contains(autor));
    }

    @Test
    public void testAdicionarAutorRepetido() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Biblioteca biblioteca = new Biblioteca();

        try {
            biblioteca.AdicionarAutor(autor);
            biblioteca.AdicionarAutor(autor);
            Assert.fail("Permitiu adicionar autor já existente");

            } catch (Exception ex) {
            Assert.fail(("Erro ao adicionar autor já existente: " + ex.getMessage()));
            }

    }

    @Test
    public void testRemoverAutor() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
       
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarAutor(autor);
        biblioteca.RemoverAutor(autor);
        
        Assert.assertFalse(biblioteca.autores.contains(autor));
    }
    
    @Test
    public void testRemoverAutorNaoExistente() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
      
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.AdicionarAutor(autor);
        biblioteca.RemoverAutor(autor);

        try {
            biblioteca.RemoverAutor(autor);
            Assert.fail(("Permitiu remover autor não existente sem exibir erro"));
            } catch (Exception ex) {
            Assert.fail(("Erro ao remover autor não existente: " + ex.getMessage()));
            }
    }
    
    @Test
    public void testAdicionarEditora() {
        Editora editora = new Editora("Nome da Editora");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.AdicionarEditora(editora);
        
        Assert.assertTrue(biblioteca.editoras.contains(editora));         
    }

    @Test
    public void testAdicionarEditoraRepetido() {
        Editora editora = new Editora("Nome da Editora");
        Biblioteca biblioteca = new Biblioteca();

        try {
            biblioteca.AdicionarEditora(editora);
            biblioteca.AdicionarEditora(editora);
            Assert.fail("Permitiu adicionar editora já existente");

            } catch (Exception ex) {
            Assert.fail(("Erro ao adicionar editora já existente: " + ex.getMessage()));
            }

    }
    
    @Test
    public void testRemoverEditora() {
        Editora editora = new Editora("Nome da Editora");
       
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarEditora(editora);
        biblioteca.RemoverEditora(editora);
        
        Assert.assertFalse(biblioteca.editoras.contains(editora));
        
    }
    
    @Test
    public void testRemoverEditoraNaoExistente() {
        Editora editora = new Editora("Nome da Editora");
      
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.AdicionarEditora(editora);

        biblioteca.RemoverEditora(editora);

        try {
            biblioteca.RemoverEditora(editora);
            Assert.fail(("Permitiu remover editora não existente sem exibir erro"));
            } catch (Exception ex) {
            Assert.fail(("Erro ao remover editora não existente: " + ex.getMessage()));
            }
    }
    
    @Test
    public void testAdicionarEstoque() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);       
        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AdicionarEstoque(livroEstoque);

        Assert.assertTrue(biblioteca.estoque.contains(livroEstoque));
    }

    @Test
    public void testAdicionarEstoqueRepetido() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);       
        Biblioteca biblioteca = new Biblioteca();

        try {
            biblioteca.AdicionarEstoque(livroEstoque);
            biblioteca.AdicionarEstoque(livroEstoque);
            Assert.fail("Permitiu adicionar estoque já existente");

            } catch (Exception ex) {
            Assert.fail(("Erro ao adicionar estoque já existente: " + ex.getMessage()));
            }

    }
    
    @Test
    public void testRemoverEstoque() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);              
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.AdicionarEstoque(livroEstoque);
        biblioteca.RemoverEstoque(livroEstoque);

        Assert.assertFalse(biblioteca.estoque.contains(livroEstoque));

    }
    
    @Test
    public void testRemoverEstoqueNaoExistente() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);             
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.AdicionarEstoque(livroEstoque);

        biblioteca.RemoverEstoque(livroEstoque);

        try {
            biblioteca.RemoverEstoque(livroEstoque);
            Assert.fail(("Permitiu remover estoque não existente sem exibir erro"));
            } catch (Exception ex) {
            Assert.fail(("Erro ao remover estoque não existente: " + ex.getMessage()));
            }
    }
}
