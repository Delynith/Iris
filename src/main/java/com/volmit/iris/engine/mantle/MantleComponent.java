/*
 * Iris is a World Generator for Minecraft Bukkit Servers
 * Copyright (c) 2021 Arcane Arts (Volmit Software)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.volmit.iris.engine.mantle;

import com.volmit.iris.core.project.loader.IrisData;
import com.volmit.iris.engine.IrisComplex;
import com.volmit.iris.engine.object.dimensional.IrisDimension;
import com.volmit.iris.util.documentation.ChunkCoordinates;
import com.volmit.iris.util.mantle.Mantle;
import com.volmit.iris.util.mantle.MantleFlag;
import com.volmit.iris.util.parallel.BurstExecutor;

import java.util.function.Consumer;

public interface MantleComponent {
    default int getRadius() {
        return getEngineMantle().getRealRadius();
    }

    default IrisData getData() {
        return getEngineMantle().getData();
    }

    default IrisDimension getDimension() {
        return getEngineMantle().getEngine().getDimension();
    }

    default IrisComplex getComplex() {
        return getEngineMantle().getComplex();
    }

    default long seed() {
        return getEngineMantle().getEngine().getTarget().getWorld().seed();
    }

    default BurstExecutor burst() {
        return getEngineMantle().getEngine().burst().burst();
    }

    EngineMantle getEngineMantle();

    default Mantle getMantle() {
        return getEngineMantle().getMantle();
    }

    MantleFlag getFlag();

    @ChunkCoordinates
    void generateLayer(int x, int z, Consumer<Runnable> post);
}
