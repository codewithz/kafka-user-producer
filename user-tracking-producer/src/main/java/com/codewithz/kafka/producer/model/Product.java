package com.codewithz.kafka.producer.model;

import com.codewithz.kafka.producer.enums.Color;
import com.codewithz.kafka.producer.enums.DesignType;
import com.codewithz.kafka.producer.enums.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Color color;

    private ProductType type;

    private DesignType designType;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public DesignType getDesignType() {
		return designType;
	}

	public void setDesignType(DesignType designType) {
		this.designType = designType;
	}
    
    

}
