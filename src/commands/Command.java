package commands;

public interface Command<Params, Result> {
    public Void run(Params params);
}