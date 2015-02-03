/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.atomic.internal;

import net.kuujo.copycat.protocol.Consistency;
import net.kuujo.copycat.state.Command;
import net.kuujo.copycat.state.Initializer;
import net.kuujo.copycat.state.Query;
import net.kuujo.copycat.state.StateContext;

/**
 * Atomic long state.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public interface AtomicLongState {

  /**
   * Initializes the state.
   *
   * @param context The state context.
   */
  @Initializer
  void init(StateContext<AtomicLongState> context);

  @Query(consistency=Consistency.STRONG)
  long get();

  @Command
  void set(long value);

  @Command
  long addAndGet(long value);

  @Command
  long getAndAdd(long value);

  @Command
  long getAndSet(long value);

  @Command
  long getAndIncrement();

  @Command
  long getAndDecrement();

  @Command
  long incrementAndGet();

  @Command
  long decrementAndGet();

  @Command
  boolean compareAndSet(long expect, long update);

}
