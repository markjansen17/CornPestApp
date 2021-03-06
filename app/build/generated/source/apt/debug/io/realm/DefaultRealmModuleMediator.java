package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.vuforia.samples.MainApp.model.CornFarming.class);
        modelClasses.add(com.vuforia.samples.MainApp.model.CornFarmingDetail.class);
        modelClasses.add(com.vuforia.samples.MainApp.model.Insect.class);
        modelClasses.add(com.vuforia.samples.MainApp.model.Disease.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return io.realm.CornFarmingRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return io.realm.CornFarmingDetailRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return io.realm.InsectRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return io.realm.DiseaseRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return io.realm.CornFarmingRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return io.realm.CornFarmingDetailRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return io.realm.InsectRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return io.realm.DiseaseRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return io.realm.CornFarmingRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return io.realm.CornFarmingDetailRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return io.realm.InsectRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return io.realm.DiseaseRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return io.realm.CornFarmingRealmProxy.getTableName();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return io.realm.CornFarmingDetailRealmProxy.getTableName();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return io.realm.InsectRealmProxy.getTableName();
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return io.realm.DiseaseRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
                return clazz.cast(new io.realm.CornFarmingRealmProxy());
            }
            if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
                return clazz.cast(new io.realm.CornFarmingDetailRealmProxy());
            }
            if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
                return clazz.cast(new io.realm.InsectRealmProxy());
            }
            if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
                return clazz.cast(new io.realm.DiseaseRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return clazz.cast(io.realm.CornFarmingRealmProxy.copyOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarming) obj, update, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return clazz.cast(io.realm.CornFarmingDetailRealmProxy.copyOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarmingDetail) obj, update, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return clazz.cast(io.realm.InsectRealmProxy.copyOrUpdate(realm, (com.vuforia.samples.MainApp.model.Insect) obj, update, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return clazz.cast(io.realm.DiseaseRealmProxy.copyOrUpdate(realm, (com.vuforia.samples.MainApp.model.Disease) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            io.realm.CornFarmingRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.CornFarming) object, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            io.realm.CornFarmingDetailRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.CornFarmingDetail) object, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            io.realm.InsectRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.Insect) object, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            io.realm.DiseaseRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.Disease) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
                io.realm.CornFarmingRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.CornFarming) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
                io.realm.CornFarmingDetailRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.CornFarmingDetail) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
                io.realm.InsectRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.Insect) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
                io.realm.DiseaseRealmProxy.insert(realm, (com.vuforia.samples.MainApp.model.Disease) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
                    io.realm.CornFarmingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
                    io.realm.CornFarmingDetailRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
                    io.realm.InsectRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
                    io.realm.DiseaseRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            io.realm.CornFarmingRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarming) obj, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            io.realm.CornFarmingDetailRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarmingDetail) obj, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            io.realm.InsectRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.Insect) obj, cache);
        } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            io.realm.DiseaseRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.Disease) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
                io.realm.CornFarmingRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarming) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
                io.realm.CornFarmingDetailRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.CornFarmingDetail) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
                io.realm.InsectRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.Insect) object, cache);
            } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
                io.realm.DiseaseRealmProxy.insertOrUpdate(realm, (com.vuforia.samples.MainApp.model.Disease) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
                    io.realm.CornFarmingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
                    io.realm.CornFarmingDetailRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
                    io.realm.InsectRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
                    io.realm.DiseaseRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return clazz.cast(io.realm.CornFarmingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return clazz.cast(io.realm.CornFarmingDetailRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return clazz.cast(io.realm.InsectRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return clazz.cast(io.realm.DiseaseRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return clazz.cast(io.realm.CornFarmingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return clazz.cast(io.realm.CornFarmingDetailRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return clazz.cast(io.realm.InsectRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return clazz.cast(io.realm.DiseaseRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarming.class)) {
            return clazz.cast(io.realm.CornFarmingRealmProxy.createDetachedCopy((com.vuforia.samples.MainApp.model.CornFarming) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.CornFarmingDetail.class)) {
            return clazz.cast(io.realm.CornFarmingDetailRealmProxy.createDetachedCopy((com.vuforia.samples.MainApp.model.CornFarmingDetail) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Insect.class)) {
            return clazz.cast(io.realm.InsectRealmProxy.createDetachedCopy((com.vuforia.samples.MainApp.model.Insect) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.vuforia.samples.MainApp.model.Disease.class)) {
            return clazz.cast(io.realm.DiseaseRealmProxy.createDetachedCopy((com.vuforia.samples.MainApp.model.Disease) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
