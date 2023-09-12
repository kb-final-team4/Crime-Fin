<template>
  <v-container class="content">
    <v-row class="text-center">
      <v-col cols="12">
        <v-img
          :src="require('../assets/CRIME.png')"
          class="my-3"
          contain
          height="200"
        />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">
          Welcome to Vuetify
        </h1>

        <p class="subheading font-weight-regular">
          For help and collaboration with other Vuetify developers,
          <br>please join our online
          <a
            href="https://community.vuetifyjs.com"
            target="_blank"
          >Discord Community</a>
        </p>
      </v-col>

      <v-col
        class="mb-5"
        cols="12"
      >
        <h2 class="headline font-weight-bold mb-3">
          What's next?
        </h2>

        <v-row justify="center">
          <a
            v-for="(next, i) in whatsNext"
            :key="i"
            :href="next.href"
            class="subheading mx-3"
            target="_blank"
          >
            {{ next.text }}
          </a>
        </v-row>
      </v-col>

      <v-col
        class="mb-5"
        cols="12"
      >
        <h2 class="headline font-weight-bold mb-3">
          Important Links
        </h2>

        <v-row justify="center">
          <a
            v-for="(link, i) in importantLinks"
            :key="i"
            :href="link.href"
            class="subheading mx-3"
            target="_blank"
          >
            {{ link.text }}
          </a>
        </v-row>
      </v-col>

      <v-col
        class="mb-5"
        cols="12"
      >
        <h2 class="headline font-weight-bold mb-3">
          Ecosystem
        </h2>

        <v-row justify="center">
          <a
            v-for="(eco, i) in ecosystem"
            :key="i"
            :href="eco.href"
            class="subheading mx-3"
            target="_blank"
          >
            {{ eco.text }}
          </a>
        </v-row>
      </v-col>
    </v-row>

    <div class="content">
    <!-- 카드 목록 -->
    <v-container>
      <v-layout column>
        <!-- 첫 번째 카드 -->
        <v-flex>
          <v-card class="mb-4" dark>
            <!-- 썸네일 이미지 -->
            <v-img src="썸네일1.jpg" height="200"></v-img>

            <!-- 기사 링크 -->
            <v-card-title class="headline">
              <a href="링크1" target="_blank">기사 제목 1</a>
            </v-card-title>

            <!-- 간단한 내용 -->
            <v-card-text>기사 요약 1</v-card-text>
          </v-card>
        </v-flex>

        <!-- 카드 사이에 구분선 추가 -->
        <v-divider></v-divider>

        <!-- 두 번째 카드 -->
        <v-flex>
          <v-card class="mb-4" dark>
            <!-- 썸네일 이미지 -->
            <v-img src="썸네일2.jpg" height="200"></v-img>

            <!-- 기사 링크 -->
            <v-card-title class="headline">
              <a href="링크2" target="_blank">기사 제목 2</a>
            </v-card-title>

            <!-- 간단한 내용 -->
            <v-card-text>기사 요약 2</v-card-text>
          </v-card>
        </v-flex>

        <!-- 카드 사이에 구분선 추가 -->
        <v-divider></v-divider>

        <!-- 세 번째 카드 -->
        <v-flex>
          <v-card class="mb-4" dark>
            <!-- 썸네일 이미지 -->
            <v-img src="썸네일3.jpg" height="200"></v-img>

            <!-- 기사 링크 -->
            <v-card-title class="headline">
              <a href="링크3" target="_blank">기사 제목 3</a>
            </v-card-title>

            <!-- 간단한 내용 -->
            <v-card-text>기사 요약 3</v-card-text>
          </v-card>
        </v-flex>

        <!-- 카드 사이에 구분선 추가 -->
        <v-divider></v-divider>

        <!-- 네 번째 카드 -->
        <v-flex>
          <v-card class="mb-4" dark>
            <!-- 썸네일 이미지 -->
            <v-img src="썸네일4.jpg" height="200"></v-img>

            <!-- 기사 링크 -->
            <v-card-title class="headline">
              <a href="링크4" target="_blank">기사 제목 4</a>
            </v-card-title>

            <!-- 간단한 내용 -->
            <v-card-text>기사 요약 4</v-card-text>
          </v-card>
        </v-flex>

        <!-- 카드 사이에 구분선 추가 -->
        <v-divider></v-divider>

        <!-- 다섯 번째 카드 -->
        <v-flex>
          <v-card class="mb-4" dark>
            <!-- 썸네일 이미지 -->
            <v-img src="썸네일5.jpg" height="200"></v-img>

            <!-- 기사 링크 -->
            <v-card-title class="headline">
              <a href="링크5" target="_blank">기사 제목 5</a>
            </v-card-title>

            <!-- 간단한 내용 -->
            <v-card-text>기사 요약 5</v-card-text>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
  </v-container>
</template>

<script>
  export default {
    name: 'HelloWorld',

    data() {
    return {
      articles: [
        {
          title: '기사 제목 1',
          link: '링크1',
          summary: '기사 요약 1',
          thumbnail: '썸네일1.jpg',
        },
        {
          title: '기사 제목 2',
          link: '링크2',
          summary: '기사 요약 2',
          thumbnail: '썸네일2.jpg',
        },
        {
          title: '기사 제목 3',
          link: '링크3',
          summary: '기사 요약 3',
          thumbnail: '썸네일3.jpg',
        },
        {
          title: '기사 제목 4',
          link: '링크4',
          summary: '기사 요약 4',
          thumbnail: '썸네일4.jpg',
        },
        {
          title: '기사 제목 5',
          link: '링크5',
          summary: '기사 요약 5',
          thumbnail: '썸네일5.jpg',
        },
      ],
    };
  },
  }
</script>
<style scoped>
.content {
  background-color: black;
}
</style>