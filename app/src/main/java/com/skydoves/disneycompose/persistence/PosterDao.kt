/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
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

package com.skydoves.disneycompose.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skydoves.disneycompose.model.Poster

@Dao
interface PosterDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertPosterList(posters: List<Poster>)

  @Query("SELECT * FROM Poster WHERE id = :id_")
  fun getPoster(id_: Long): LiveData<Poster>

  @Query("SELECT * FROM Poster")
  suspend fun getPosterList(): List<Poster>
}
