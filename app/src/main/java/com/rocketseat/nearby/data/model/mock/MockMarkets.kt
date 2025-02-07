package com.rocketseat.nearby.data.model.mock

import com.rocketseat.nearby.data.model.Market


object MockDataService {
    val mockMarkets = listOf(
        Market(
            id = "0125765ea-4441-4b8a-89e5-d5f3871c74c4",
            categoryId = "1416b488-bd33-4322-8b8f-cf08f6f18e6d",
            name = "Sabor Grill",
            description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para toda a família.",
            coupons = 10,
            //rules = emptyList(),
            latitude = -23.557942013919911,
            longitude = -46.64850458749887,
            address = "Av. Paulista - Bela Vista",
            phone = "(11) 94567-1212",
            cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=600&h=300"
        ),
        Market(
            id = "2cb1e34-5f30-4ba0-9f6a-c19f684f9281",
            categoryId = "1416b488-bd33-4322-8b8f-cf08f6f18e6d",
            name = "Café Central",
            description = "Café aconchegante com opções de lanches e bebidas artesanais. Perfeito para encontros e reuniões.",
            coupons = 10,
            //rules = emptyList(),
            latitude = -23.55794570854346,
            longitude = -46.652057215344,
            address = "Alameda Jaú - Jardim Paulista",
            phone = "(12) 3456-7890",
            cover = "https://images.unsplash.com/photo-1551218880-94e2202d8ede?w=600&h=300"
        )
    )

    fun getMockMarkets(categoryId: String): List<Market> {
        // Aqui você pode adicionar lógica para filtrar os mercados pela categoria, se necessário
        return mockMarkets
    }
}

