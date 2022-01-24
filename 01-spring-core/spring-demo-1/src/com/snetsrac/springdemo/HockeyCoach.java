package com.snetsrac.springdemo;

public class HockeyCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;
    private int teeth;

    public HockeyCoach() {}

    public HockeyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }

    @Override
    public String getDailyWorkout() {
        return "Hit the puck with the stick, eh?";
    }

    @Override
    public String getDailyFortune() {
        if (fortuneService == null) {
            return "I need a fortune service, eh?";
        }

        String fortune = fortuneService.getFortune();
        return fortune.substring(0, fortune.length() - 1) + ", eh?";
    }
}
