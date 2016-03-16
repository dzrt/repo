<?php
include_once 'header.php';
include_once 'funcoes.php';
$query = "SELECT faq.q,faq.a FROM faq";
$ligar = ligar_base_dados();
$result = mysql_query($query,  $ligar);
?>
<section style="text-align: center;" class='testff'>
    <h1>FAQ's</h1>
    <?php
    $var2 = 1;
    while($array = mysql_fetch_assoc($result)){
        ?><p onclick="showhide(<?=$var2?>)" style="margin:1% auto;padding:0.5%;width: 50%;-moz-box-shadow:    inset 0 0 10px #000000;
   -webkit-box-shadow: inset 0 0 10px #000000;
   box-shadow:         inset 0 0 10px #000000;cursor: pointer;" onmouseover="this.style.color='#66CCCC'" onmouseout="this.style.color='black'" id='q<?=$var2?>'><?php echo $array['q'] ?>?<span style="float:right;margin-right: 1%;"/><img id='<?=$var2?>' src="images/arrow-down-3-xxl.png" height="20px" width="20px"/></p>
        <p style="width: 50%;margin: auto; border:1px solid black;display: none;font-weight: bold;color: green;" id='a<?=$var2?>'>Resposta : <?php echo $array['a'] ?></p>
            <?php
            $var2++;
    }
    mysql_close($ligar);
    ?>
        <div style="margin-top: 15%;">
            <h2>Efetuar pergunta</h2>
            <p>Poderá perguntar sobre algo nesta secção, a sua pergunta será respondida eventualmente</p>
            <form>
                <textarea style="resize:none;" name="" rows="4" cols="80" required></textarea><br>
                <input type="submit" class="btn btn-theme02" value="Efetuar"/>
            </form>
        </div>
</section>
<script type="text/javascript">
    function showhide(x){
        if(!isv(x)){
            document.getElementById('a'+x).style.display = 'block';
            document.getElementById(x).src = 'images/arrow-down-3-xxl2.png' ;
        }else{
            document.getElementById('a'+x).style.display = 'none';
            document.getElementById(x).src = 'images/arrow-down-3-xxl.png' ;
        }
    }
    function isv(x){
        var flag = document.getElementById('a'+x).style.display;
    if(flag === 'block'){
        return true;
    }else{
        return false;
    }
    }
</script>
<?php
include_once 'footer.php';
?>