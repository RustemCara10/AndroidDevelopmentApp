package com.example.trytry;

public class Product {


    String productName;
    int productQuantity;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImagecode(int productImagecode) {
        this.productImagecode = productImagecode;
    }

    int productPrice;
    int productImagecode;

        public Product(String productName, int productQuantity, int productPrice, int productImagecode) {
            this.productName = productName;
            this.productQuantity = productQuantity;
            this.productPrice = productPrice;
            this.productImagecode = productImagecode;
        }

        public String getProductName() {
            return productName;
        }

        public int getProductQuantity() {
            return productQuantity;
        }

        public int getProductPrice() {
            return productPrice;
        }

        public int getProductImagecode() {
            return productImagecode;
        }
    }


