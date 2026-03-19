package com.fag.lucasmartins.arquitetura_software.service;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto) {

        Produto produto = new Produto(
                dto.getNome(),
                dto.getEstoque(),
                dto.getPreco()
        );

        produto.validarProdutoPremium();
        produto.aplicarDesconto();

        repository.salvar(produto);

        ProdutoResponseDTO response = new ProdutoResponseDTO();
        response.setNome(produto.getNome());
        response.setEstoque(produto.getEstoque());
        response.setPreco(produto.getPreco());
        response.setPrecoFinal(produto.getPrecoFinal());
        response.setMensagem("Produto cadastrado com sucesso!");

        return response;
    }
}