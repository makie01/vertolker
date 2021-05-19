package vertolker;

public interface Value {
	public static Value evaluate(Value value1, char operator, Value value2) {
		switch(operator) {
		case '+':
			if (value1 instanceof AddableValue)
				return ((AddableValue)value1).add(value2);
			else if (value1 instanceof StringValue && value2 instanceof StringValue)
				return new StringValue(((StringValue)value1).value + ((StringValue)value2).value);
			else
				throw new RuntimeException("Cannot apply + to these values");
		case '&': // & is de logische and, zonder shortcutsemantics (beide expressies worden dus sws geevalueerd)
			if (value1 instanceof AndableValue)
				return ((AndableValue)value1).and(value2);
			else
				throw new RuntimeException("Cannot apply & to these values");
		default:
			throw new RuntimeException("Operator not supported");
		}
	}
	
	default boolean isZero() {
		return this instanceof IntValue && ((IntValue)this).value == 0;
	}
}
