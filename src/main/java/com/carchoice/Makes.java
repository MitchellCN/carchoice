package com.carchoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by cmitchell on 4/20/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Makes {
    private List<Make> Makes;

    public List<Make> getMakes() {
        return Makes;
    }

    public void setMakes(List<Make> makes) {
        Makes = makes;
    }
}
