/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sirona.store.counter;

import org.apache.sirona.configuration.Configuration;
import org.apache.sirona.counters.Counter;
import org.apache.sirona.store.memory.counter.BatchCounterDataStore;

import java.util.Collection;
import java.util.logging.Logger;

public class LoggingCounterDataStore extends BatchCounterDataStore {
    private final Logger logger;

    public LoggingCounterDataStore() {
        logger = Logger.getLogger(Configuration.getProperty(
                Configuration.CONFIG_PROPERTY_PREFIX + "counter.store.logger.name", "org.apache.sirona.counters"));
    }

    protected void pushCountersByBatch(final Collection<Counter> instance) {
        for (final Counter c : instance) {
            logger.info(format(c));
        }
    }

    protected String format(final Counter c) {
        return c.toString();
    }
}
