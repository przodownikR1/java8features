package pl.java.scalatech.functional.bean;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

import com.google.common.collect.Maps;

@Data
@Builder
public class Ranking {

    private int rankingPoints;
    private Boxer boxer;
    private Organization orgranization;
    private Map<Organization, Ranking> federationRanking = Maps.newHashMap();

}
