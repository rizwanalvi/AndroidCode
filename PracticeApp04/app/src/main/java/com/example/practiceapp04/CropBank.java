package com.example.practiceapp04;

public class CropBank {
    private int[] _Crops = {R.drawable.bajara,
            R.drawable.jawar,R.drawable.rice,R.drawable.soyabean,R.drawable.wheat,R.drawable.cotton,R.drawable.sugarcane,R.drawable.tea};

    private String[] _CropsDetails = {"Pearl millet (Pennisetum glaucum) is the most widely grown type of millet. It has been grown in Africa and the Indian subcontinent since prehistoric times. The center of diversity, and suggested area of domestication, for the crop is in the Sahel zone of West Africa. Recent archaeobotanical research has confirmed the presence of domesticated pearl millet on the Sahel zone of northern Mali between 2500 and 2000 BC.[1] Cultivation subsequently spread and moved overseas to India. The earliest archaeological records in the Indian subcontinent date to around 2000 BC,[2] and it spread rapidly through Northern Indian subcontinent reaching South India by 1500 BC, based on evidence from the site of Hallur. Cultivation also spread throughout eastern and southern parts of Africa. Pearl millet is widely grown in the northeastern part of Nigeria (especially in Borno and Yobe states). It is a major source of food to the local villagers of that region. The crop grows easily in that region due to its ability to withstand harsh weather conditions like drought and flood. Records exist for cultivation of pearl millet in the United States in the 1850s, and the crop was introduced into Brazil in the 1960s.",
            "Sorghum bicolor, commonly called sorghum[2] (/ˈsɔːrɡəm/) and also known as great millet,[3] durra, jowari, or milo, is a grass species cultivated for its grain, which is used for food for humans, animal feed, and ethanol production. Sorghum originated in Africa, and is now cultivated widely in tropical and subtropical regions.[4] Sorghum is the world's fifth-most important cereal crop after rice, wheat, maize, and barley. S. bicolor is typically an annual, but some cultivars are perennial. It grows in clumps that may reach over 4 m high. The grain is small, ranging from 2 to 4 mm in diameter. Sweet sorghums are sorghum cultivars that are primarily grown for forage, syrup production, and ethanol; they are taller than those grown for grain.",
            "Rice is the seed of the grass species Oryza sativa (Asian rice) or Oryza glaberrima (African rice). As a cereal grain, it is the most widely consumed staple food for a large part of the world's human population, especially in Asia. It is the agricultural commodity with the third-highest worldwide production (rice, 741.5 million tonnes in 2014), after sugarcane (1.9 billion tonnes) and maize (1.0 billion tonnes).[1]",
            "The soybean or soya bean (Glycine max) is a species of legume native to East Asia, widely grown for its edible bean, which has numerous uses. Traditional unfermented food uses of soybeans include soy milk, from which tofu and tofu skin are made.",
            "Wheat is a grass widely cultivated for its seed, a cereal grain which is a worldwide staple food. The many species of wheat together make up the genus Triticum; the most widely grown is common wheat (T. aestivum).",
            "Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae. The fiber is almost pure cellulose. Under natural conditions, the cotton bolls will increase the dispersal of the seeds.",
            "Sugarcane, or sugar cane, or simply cane, are several species of tall perennial true grasses of the genus Saccharum, tribe Andropogoneae, used for sugar production. The plant is two to six metres (six to twenty feet) tall.",
            "Tea Plant. Camellia sinensis. ... The tea plant is an evergreen shrub that provides us with black, white, yellow, and green tea as well as oolong and pu-erh tea. It is the leaves and leaf buds that are commonly used to produce the teas we enjoy."};

    public int GetImage(int CropId){

                return _Crops[CropId];
    }

    public String GetDetails(int CropId){

        return _CropsDetails[CropId];
    }
}

