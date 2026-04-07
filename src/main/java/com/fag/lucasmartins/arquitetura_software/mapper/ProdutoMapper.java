package com.fag.lucasmartins.arquitetura_software.mapper;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequestDTO dto) {
        return new Produto(
                dto.getNome(),
                dto.getEstoque(),
                dto.getPreco()
        );
    }

    public static ProdutoResponseDTO toResponseDTO(Produto produto) {

        ProdutoResponseDTO response = new ProdutoResponseDTO();

        response.setNome(produto.getNome());
        response.setEstoque(produto.getEstoque());
        response.setPreco(produto.getPreco());
        response.setPrecoFinal(produto.getPrecoFinal());
        response.setMensagem("Produto cadastrado com sucesso!");

        return response;
    }
}