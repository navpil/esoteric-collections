package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EsotericCollectionsFactory {

    /**
     * One may add and check the size, but no removal is possible.
     * This check is so greedy that it won't even allow getting the elements.
     * But it's generous enough to let you know the size.
     * One may always use reflection for getting hold of elements.
     */
    static final BooleanBasedSimpleAllowCheck GREEDY_CHECK = BooleanBasedSimpleAllowCheck
            .getBuilder()
            .getForbidden()
            .removeForbidden()
            .iterationForbidden()
            .containsForbidden()
            .setForbidden()
            .create();

    static final BooleanBasedSimpleAllowCheck ONLY_SHRINKING = BooleanBasedSimpleAllowCheck
            .getBuilder()
            .addForbidden()
            .setForbidden()
            .create();

    static final BooleanBasedSimpleAllowCheck SIZE_FORBIDDEN = BooleanBasedSimpleAllowCheck
            .getBuilder()
            .sizeForbidden()
            .create();

    /**
     * The least secure collections - they allow all methods, including add and remove
     */
    static final BooleanBasedSimpleAllowCheck ALLOW_ALL = BooleanBasedSimpleAllowCheck
            .getBuilder()
            .create();

    /**
     * The most secure collection
     *
     * @return
     * @param <T>
     */
    public static <T> List<T> createForbidAllOperationsList(T ... objects) {
        return new ConditionalListWrapper<>(new ArrayList<>(Arrays.asList(objects)), BooleanBasedSimpleAllowCheck.getBuilder()
                .addForbidden()
                .getForbidden()
                .iterationForbidden()
                .containsForbidden()
                .removeForbidden()
                .setForbidden()
                .sizeForbidden()
                .create());

    }

    public static <T> List<T> asNoGetList(List<T> list) {
        return new ConditionalListWrapper<>(list, GREEDY_CHECK);
    }

}
