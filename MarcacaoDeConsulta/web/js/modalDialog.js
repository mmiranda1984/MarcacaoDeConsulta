

function callBackEdicao(xhr, status, args) {
    if(!args.validationFailed)
        dlgCadastro.hide();
}

function callBackExclusao(xhr, status, args) {
    if(!args.validationFailed && !args.msgErro)
        dialogExcluir.hide();
}
