package pl.java.scalatech.functional.bean;

import java.util.Map;

import com.google.common.collect.Maps;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class Ranking {

    private int rankingPoints;
    private Boxer boxer;
    private Organization orgranization;
    private Map<Organization,Ranking> federationRanking = Maps.newHashMap();
    
}
