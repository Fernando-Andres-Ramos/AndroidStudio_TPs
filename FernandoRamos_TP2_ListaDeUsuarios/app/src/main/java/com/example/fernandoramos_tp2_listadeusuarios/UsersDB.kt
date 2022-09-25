package com.example.fernandoramos_tp2_listadeusuarios


/* Repositorio de datos mockeados. */
class UsersDB {
    companion object{
        private val users = arrayOf(
            User(
                1,
                "Fernando",
                27, "Argentina",
                "https://viajes.nationalgeographic.com.es/medio/2018/02/27/hemis-0548910__800x800.jpg",
                "emailFer",
                123456789,
                "callefalsa123"),
            User(
                2,
                "Vera",
                35,
                "Nicaragua",
                "https://thumbs.dreamstime.com/b/hermoso-paisaje-de-monta%C3%B1a-verano-vastos-prados-y-bosques-214333311.jpg",
                "emailVera",
                987654321,
                "Otracalle321"),
            User(
                3,
                "Mauro",
                28,
                "Argentina",
                "https://viajes.nationalgeographic.com.es/medio/2018/02/27/hemis-0255544__800x800.jpg",
                "emailMauro",
                123456,
                "tokio"),
            User(
                4,
                "Ayelen",
                29,"Argentina",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqrd4qx718rIBlZ5ZMlqWZl6vfK8SmQzMMLcp-V9RQ9ZJqCxGYlGtVjyMYCwAoEG3Up-M&usqp=CAU",
                "emailAye",
                1234589,
                "Canada"),
            User(
                5,
                "Patricia",
                52,
                "Argentina",
                "https://i1.adis.ws/i/canon/pro-best-mirrorless-kit-landscapes-1-1x1_3e52b8e3302a457181059b0a67ecc92b",
                "emailMama",
                12333333,
                "garcia merou"),
            User(6,
                "Tatiana",
                27,
                "Argentina",
                "Algo",
                "emailTaty",
                987321,
                "algun lado")
        )
    }

    fun getUsers():Array<User>{
        users.shuffle()
        return users
    }

    fun findUserByID(id:Int):User?{
        for (user in users){
            if(user.id == id)
                return user
        }
        return null
    }
}