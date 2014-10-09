package commands;


public interface Command<Params, Result> {
	public Result run(Params params);
}