package com.fag.lucasmartins.arquitetura_software.service;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.mapper.ProdutoMapper;
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

        Produto produto = ProdutoMapper.toEntity(dto);

        produto.validarProdutoPremium();
        produto.aplicarDesconto();

        repository.salvar(produto);

        return ProdutoMapper.toResponseDTO(produto);
    }
}