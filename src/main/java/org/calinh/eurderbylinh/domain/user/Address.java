package org.calinh.eurderbylinh.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    public Address(AddressBuilder addressBuilder) {
        this.streetName = addressBuilder.streetName;
        this.streetNumber = addressBuilder.streetNumber;
        this.postCode = addressBuilder.postCode;
        this.city = addressBuilder.city;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static final class AddressBuilder {
        private String streetName;
        private String streetNumber;
        private String postCode;
        private String city;

        private AddressBuilder() {
        }

        public static AddressBuilder addressBuilder() {
            return new AddressBuilder();
        }

        public Address build() {
            return new Address(this);
        }

        public AddressBuilder withStreetName(@JsonProperty("streetName") String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withStreetNumber(@JsonProperty("streetNumber") String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder withPostCode(@JsonProperty("postCode") String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressBuilder withCity(@JsonProperty("city") String city) {
            this.city = city;
            return this;
        }
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}