/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.orchestration.internal.config;

import com.google.common.base.Joiner;
import lombok.RequiredArgsConstructor;

/**
 * Data configuration node.
 *
 * @author caohao
 * @author panjuan
 */
@RequiredArgsConstructor
public final class ConfigurationNode {
    
    @Deprecated
    public static final String PROXY_NODE = "proxy";
    
    private static final String ROOT = "config";
    
    private static final String DATA_SOURCE_NODE = "datasource";
    
    private static final String RULE_NODE = "rule";
    
    private static final String CONFIG_MAP_NODE = "configmap";
    
    private static final String PROPS_NODE = "props";
    
    @Deprecated
    private static final String SERVER_NODE = "server";
    
    private final String name;
    
    /**
     * Get data source path.
     *
     * @param schemaName schema name
     * @return data source path
     */
    public String getDataSourcePath(final String schemaName) {
        return getFullPath(schemaName, DATA_SOURCE_NODE);
    }
    
    /**
     * Get rule path.
     * 
     * @param schemaName schema name
     * @return rule path
     */
    public String getRulePath(final String schemaName) {
        return getFullPath(schemaName, RULE_NODE);
    }
    
    /**
     * Get config map path.
     *
     * @param schemaName schema name
     * @return config map path
     */
    public String getConfigMapPath(final String schemaName) {
        return getFullPath(schemaName, CONFIG_MAP_NODE);
    }
    
    /**
     * Get props path.
     *
     * @param schemaName schema name
     * @return props path
     */
    public String getPropsPath(final String schemaName) {
        return getFullPath(schemaName, PROPS_NODE);
    }
    
    @Deprecated
    public String getServerPath(final String schemaName) {
        return getFullPath(schemaName, SERVER_NODE);
    }
    
    private String getFullPath(final String schemaName, final String node) {
        return Joiner.on("/").join("", name, ROOT, schemaName, node);
    }
}
