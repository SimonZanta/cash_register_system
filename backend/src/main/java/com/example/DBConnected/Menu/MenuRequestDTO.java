package com.example.DBConnected.Menu;

import java.util.List;

public class MenuRequestDTO {
        private long id;

        private String name;

        private int weight;

        private int price;
        private List<Long> allergensIds;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

    public List<Long> getAllergensIds() {
        return allergensIds;
    }

    public void setAllergensIds(List<Long> allergensIds) {
        this.allergensIds = allergensIds;
    }
}
