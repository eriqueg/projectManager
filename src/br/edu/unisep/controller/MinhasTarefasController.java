package br.edu.unisep.controller;

import br.edu.unisep.fx.controller.AppController;
import br.edu.unisep.model.dao.TarefaDAO;
import br.edu.unisep.model.vo.TarefaVO;
import br.edu.unisep.utils.UsuarioUtils;
import br.edu.unisep.view.FazendoCell;
import br.edu.unisep.view.FeitoCell;
import br.edu.unisep.view.NovaTarefaCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MinhasTarefasController extends AppController {

    @FXML private ListView<TarefaVO> lstAfazer;
    @FXML private ListView<TarefaVO> lstFazendo;
    @FXML private ListView<TarefaVO> lstFeito;


    private ObservableList<TarefaVO> aFazer;
    private ObservableList<TarefaVO> fazendo;
    private ObservableList<TarefaVO> feito;


    @Override
    protected void onInit() {
        var dao = new TarefaDAO();

        aFazer = FXCollections.observableArrayList();
        fazendo = FXCollections.observableArrayList();
        feito = FXCollections.observableArrayList();

        lstAfazer.setCellFactory(f -> new NovaTarefaCell());
        lstFazendo.setCellFactory(y -> new FazendoCell());
        lstFeito.setCellFactory(f -> new FeitoCell());

        var listAfazer = dao.listarPorStatus(UsuarioUtils.getUsuario(), 1);
        var listFazendo = dao.listarPorStatus(UsuarioUtils.getUsuario(), 2);
        var listFeito = dao.listarPorStatus(UsuarioUtils.getUsuario(), 3);

        aFazer.setAll(listAfazer);
        lstAfazer.setItems(aFazer);

        fazendo.setAll(listFazendo);
        lstFazendo.setItems(fazendo);

        feito.setAll(listFeito);
        lstFeito.setItems(feito);


    }
}
