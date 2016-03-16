<?php
include_once 'mysql_connect.php';

function ligar_base_dados(){
    $ligacao = mysql_connect(MYSQL_SERVER, MYSQL_USERNAME, MYSQL_PASSWORD) or die('Erro ao ligar ao servidor...');        
    mysql_select_db(MYSQL_DATABASE, $ligacao) or die('Erro ao selecionar a base de dados...');
    return $ligacao;
}
?>