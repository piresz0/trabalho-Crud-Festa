val expressaoRegular = Regex("[0-4]")
//Variavel global
var convidado : Convidado = Convidado()
//Instancia de uma lista mutavel vazia
var listaConvidados : MutableList<Convidado> = mutableListOf<Convidado>()


fun main() {
   menu()
}


private fun menu(){
    do {

        println("--- MENU ---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("5- SAIR")

        val opcao = readln()
        if(expressaoRegular.matches(opcao)) {


        } else{
            println("\n" +
                    "\n" +
                    "\n" +
                    "Opção invalida!! ")
        }



        if (expressaoRegular.matches(opcao)) {
            when (opcao.toInt()) {
                1 -> {
                    println("Cadastrando...")
                    cadastrar()
                }

                2 -> {
                    println("Listando...")
                    listar()
                }

                3 -> {
                    println("Editando...")
                    editar()
                }

                4 -> {
                    println("Excluindo...")
                    excluir()
                }

                5 -> println("Saindo...")
            }

        }
    } while (true)
}

private fun cadastrar(){
    //Instancia
    var convidado = Convidado()

    print("Qual o seu nome? ")
    //var nome = readln()
    convidado.nome = readln()

    print("Qual sua restrição alimentar? ")
    //var alimentar = readln()
    convidado.alimentar = readln()

    print("Qual vai ser o presente? ")
    //val presente = readln()
    convidado.presente = readln()

    listaConvidados.add(convidado)
}

/* fun algumacoisa() : tipo esperasse que a função
* recebe esse tipo no final dela com um return
*/

private fun listar() {
    var i = 0

    if (listaConvidados.isEmpty()) {
        println("Não há convidados")
    } else {
        listaConvidados.forEach { convidado ->
            print(
                "posição: ${i++}" +
                        "Nome: ${convidado.nome};" +
                        "Presente: ${convidado.presente}; Resposta: " +
                        "Restrição: ${convidado.alimentar};" +
                        "Vai ir a festa? ${convidado.presenca}\n"
            )
        }
    }

}

private fun editar() :Boolean{
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!!")
        return false
    }
        listar()

    println("Digite a posição a ser editada: ")
    val posicao = readln().toInt()

    println("O convidado vai? S/N")
    val resposta = readln()
    when(resposta){
        "S" -> listaConvidados[posicao].presenca = true
        "N" -> listaConvidados[posicao].presenca = false
    }
    return true
}

private fun excluir() :Boolean {
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!!")
        return false
    }
    listar()

    println("Qual posição voce deseja remover: ")
    val posicao = readln().toInt()
    listaConvidados.removeAt(posicao)

    println("Convidado excluido")
    return true

    /*convidado.nome = ""
    convidado.alimentar = ""
    convidado.presente = ""
    convidado.presenca = false*/


}