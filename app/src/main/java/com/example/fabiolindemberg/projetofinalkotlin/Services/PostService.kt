package com.example.fabiolindemberg.projetofinalkotlin.Services

import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post

class PostService{

    companion object {

        fun getPosts(): List<Post> {
            val posts = mutableListOf<Post>()

            /*
            * ´this peace of code create some static posts,
            *  in future, it should be replace by a http request
            * */
            posts.add(Post(1, "Jair M. Bolsonaro", "A violência é um dos grandes problemas que temos. A maior preocupação de um pai, de uma mãe, é que os filhos voltem para casa em paz."))
            posts.add(Post(2, "Jair M. Bolsonaro", "Em conversa com o Sec. nacional de Pesca e Agricultura, @jorgeseif , nos foi informado que burocracia no setor é o que mais tem travado o crescimento da produção nas 5 regiões do país."))
            posts.add(Post(3, "Jair M. Bolsonaro", "Porta-voz da Presidência da República expõe como foi a agenda do Governo no dia de hoje (18/02/2019)."))
            posts.add(Post(4, "Programa Pânico", "A Beby tá aqui."))
            posts.add(Post(5, "TMX Group", "How has the increased demand in electric vehicle production affected the mining sector?"))
            posts.add(Post(6, "Samara não a do poço", "claro q ela não pensou em chamar uma MULHER pra falar de um assunto sobre MULHERES pq quem sofre violência é a MULHER"))

            return posts
        }
    }
}