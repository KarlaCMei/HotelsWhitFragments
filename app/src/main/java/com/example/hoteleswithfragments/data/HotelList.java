package com.example.hoteleswithfragments.data;

import com.example.hoteleswithfragments.adapters.Imagen;

import java.util.ArrayList;

public class HotelList {

    private static ArrayList<Hotel> listHotel;
    private static ArrayList<Imagen> listImages;

    //private static ArrayList<String> listImages;



    public static ArrayList<Hotel> getHotels(){
        if(listImages == null) listImages = new ArrayList<>();
        listImages.clear();
        listImages.add(new Imagen("titulo1","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086738.jpeg"));
        listImages.add(new Imagen("titulo2","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086700.jpeg"));
        listImages.add(new Imagen("titulo3","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/91/89/918916060.jpeg"));
        listImages.add(new Imagen("titulo4","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086736.jpeg"));
        listImages.add(new Imagen("titulo5","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086694.jpeg"));
        listImages.add(new Imagen("titulo6","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/81/14/811428470.jpeg"));
        listImages.add(new Imagen("titulo7","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086810.jpeg"));
        listImages.add(new Imagen("titulo8","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/11/47/1147086830.jpeg"));
        listImages.add(new Imagen("titulo9","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/38/53/385346288.jpeg"));
        listImages.add(new Imagen("titulo10","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/81/14/811428510.jpeg"));

        if(listHotel == null) listHotel = new ArrayList<>();
        listHotel.add(new Hotel("4 estrellas", "Hotel Realeza",
                "Con 5 piscinas al aire libre, el Riu Dunamar All Inclusive está situado frente a Playa Costa Mujeres, en Cancún. La propiedad cuenta con el Splash Water World, un parque acuático con toboganes, además de régimen all inclusive 24h.",
                "• El hotel está a 19,5 km del Centro de Cancún",
                "$4500",
                "$9000",
                listImages, "https://media-cdn.tripadvisor.com/media/photo-s/25/fb/8c/46/hotel-exterior.jpg"));
        listHotel.add(new Hotel("5 estrellas", "Hotel Casa Maya",
                "El Hotel Casa Maya está situado a 8 minutos en coche del centro de Cancún y ofrece vistas espléndidas a la laguna Nichupté y al mar Caribe. Cuenta con 2 restaurantes, bañera de hidromasaje y piscina al aire libre.",
                " Boulevard Kukulcan KM 5.5. Zona Hotelera, 77500 Cancún, México",
                "$8700",
                "$11078",
                listImages,"https://media.staticontent.com/media/pictures/519cbbe5-2322-4d44-b5be-d1785272f974/300x200"));
        listHotel.add(new Hotel("5 estrellas", "Queen Hotel.",
                "Cuenta con piscina al aire libre y está en Cancún, al lado de la laguna, a 400 metros de la playa Tortugas y a 3 km del centro comercial Plaza Caracol. Ofrece WiFi gratis.",
                " Boulevard Kukulcán km. 5.5, Zona Hotelera, 77507 Cancún, México –",
                "$6850",
                "$9393",
                listImages,"https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg"));

        listHotel.add(new Hotel("3 estrellas", "Oz Resort.",
                "Cuenta con piscina al aire libre y lavadora. Se encuentra frente a la playa y ofrece terraza, aparcamiento privado gratuito y WiFi gratuita.",
                " KM. 11.5 Boulevard Kukulcan, 77500 Cancún, México ",
                "$6600",
                "$8677",
                listImages,"https://consejosdecancun.com/wp-content/uploads/2018/02/hotel-em-cancun.jpg"));

        listHotel.add(new Hotel("4 estrellas", "Candel Resort.",
                "Cuenta con piscina al aire libre con vistas al mar, solárium, bañera de hidromasaje, mostrador de información turística y club infantil. Los huéspedes también pueden practicar snorkel, buceo y golf durante su estancia.",
                "Carretera a Punta Sam Km. 5.2 Mza 9 Lote 3 SM-2, Zona Continental de Isla Mujeres,, 77400 Cancún, México",
                "$4200",
                "$5600",
                listImages,"https://imgcy.trivago.com/c_lfill,f_auto,g_faces,q_auto:good,w_756/mag/2021/08/25212949/lugares-turisticos-de-baja-california-sur-mexico-exterior.jpeg"));

        return listHotel;
    }




    /*public static ArrayList<Hotel> getHotels(){
        //if(listImages == null) listImages = new ArrayList<>();

        /*listImages.add(new Imagen("titulo1","https://quelibroleo.com/images/libros/libro-1504771595.jpg"));
        listImages.add(new Imagen("titulo2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ51vJ4dsWhl3EmO4GfZftrwQt4Yt3wJmH6r8cWPOtDFgiw3Ne0kF04i_hDWGjRF68SVVA&usqp=CAU"));
        listImages.add(new Imagen("titulo3","https://canallector.com/old-thumbs/978-84-9838-234-1_g.jpg"));
        listImages.add(new Imagen("titulo4","https://es.web.img3.acsta.net/pictures/19/03/22/10/08/5883111.jpg?coixp=50&coiyp=40"));*/

        /*listImages.add(new Imagen("https://quelibroleo.com/images/libros/libro-1504771595.jpg"));
        listImages.add(new Imagen("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ51vJ4dsWhl3EmO4GfZftrwQt4Yt3wJmH6r8cWPOtDFgiw3Ne0kF04i_hDWGjRF68SVVA&usqp=CAU"));
        listImages.add(new Imagen("https://canallector.com/old-thumbs/978-84-9838-234-1_g.jpg"));
        listImages.add(new Imagen("https://es.web.img3.acsta.net/pictures/19/03/22/10/08/5883111.jpg?coixp=50&coiyp=40"));*/

       /* if(listHotel == null) listHotel = new ArrayList<>();
        listHotel.add(new Hotel("4 estrellas", "Hotel Realeza",
                "Con 5 piscinas al aire libre, el Riu Dunamar All Inclusive está situado frente a Playa Costa Mujeres, en Cancún. La propiedad cuenta con el Splash Water World, un parque acuático con toboganes, además de régimen all inclusive 24h.",
                "• El hotel está a 19,5 km del Centro de Cancún",
                "$4500","https://media-cdn.tripadvisor.com/media/photo-s/25/fb/8c/46/hotel-exterior.jpg",
                "$9000"));
        listHotel.add(new Hotel("5 estrellas", "Hotel Casa Maya",
                "El Hotel Casa Maya está situado a 8 minutos en coche del centro de Cancún y ofrece vistas espléndidas a la laguna Nichupté y al mar Caribe. Cuenta con 2 restaurantes, bañera de hidromasaje y piscina al aire libre.",
                " Boulevard Kukulcan KM 5.5. Zona Hotelera, 77500 Cancún, México",
                "$8700","https://media.staticontent.com/media/pictures/519cbbe5-2322-4d44-b5be-d1785272f974/300x200",
                "$11078"));
        listHotel.add(new Hotel("5 estrellas", "Queen Hotel.",
                "Cuenta con piscina al aire libre y está en Cancún, al lado de la laguna, a 400 metros de la playa Tortugas y a 3 km del centro comercial Plaza Caracol. Ofrece WiFi gratis.",
                " Boulevard Kukulcán km. 5.5, Zona Hotelera, 77507 Cancún, México –",
                "$6850"
                ,"https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg"
                ,"$9393"));

        listHotel.add(new Hotel("3 estrellas", "Oz Resort.",
                "Cuenta con piscina al aire libre y lavadora. Se encuentra frente a la playa y ofrece terraza, aparcamiento privado gratuito y WiFi gratuita.",
                " KM. 11.5 Boulevard Kukulcan, 77500 Cancún, México ",
                "$6600"
                ,"https://consejosdecancun.com/wp-content/uploads/2018/02/hotel-em-cancun.jpg","$8677"
                ));

        listHotel.add(new Hotel("4 estrellas", "Candel Resort.",
                "Cuenta con piscina al aire libre con vistas al mar, solárium, bañera de hidromasaje, mostrador de información turística y club infantil. Los huéspedes también pueden practicar snorkel, buceo y golf durante su estancia.",
                "Carretera a Punta Sam Km. 5.2 Mza 9 Lote 3 SM-2, Zona Continental de Isla Mujeres,, 77400 Cancún, México",
                "$4200","https://imgcy.trivago.com/c_lfill,f_auto,g_faces,q_auto:good,w_756/mag/2021/08/25212949/lugares-turisticos-de-baja-california-sur-mexico-exterior.jpeg",
                "$5600"
                ));

        return listHotel;
    }*/

}
