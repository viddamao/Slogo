// This entire file is part of my masterpiece.
// Zachary Podbela

package commands;

public interface Command<Params, Result> {
    public Result run(Params params);
}