<template>
  <div>
    <v-text-field label="ID" :rules="rulesId" hide-details="auto" style="padding-left:50px;padding-right: 50px;"></v-text-field>
    <v-text-field label="Password" :rules="rulesPw" style="padding-left:50px;padding-right: 50px;"></v-text-field>
    <div class="d-flex justify-space-around align-center flex-column flex-sm-row">
    <v-btn variant="outlined" color="primary" style="min-width: 74%;">
      Sign IN
    </v-btn>
  </div>
  </div>
</template>

<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      rulesId: [
        value => !!value || '필수값 입니다',
        value => (value && value.length >= 4) || '최소 4글자 이상 입력하세요',
      ],
      rulesPw: [
        value => !!value || '필수값 입니다',
      ],
    }
  },
}
</script>
