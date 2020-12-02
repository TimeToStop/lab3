package model.validation;

public interface Parser<V, D> {
    V parse(D data) throws ValidateException;
}
