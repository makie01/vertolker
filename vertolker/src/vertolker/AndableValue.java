package vertolker;

public interface AndableValue extends Value{
	public abstract Value and(Value other);
}
